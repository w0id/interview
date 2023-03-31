--Просто вывод общей информации о билетах:
--номер билета, дата сеанса, время сеанса, продолжительность, время окончания и цена
select t."number", fs2.show_date, f.title, f.duration, fs2.starts_at, fs2.ends_at, p.price
from film_show fs2
join film f on f.id = fs2.film
join prices p on p.id = fs2.price
join tickets t on t."show" = fs2.id

--ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
--Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
select f2.title, fs3.starts_at, f2.duration, f3.title, fs4.starts_at, f3.duration
from (
    select case
        when
            lead(fs2.starts_at, 1)
            over (order by fs2.starts_at) < fs2.ends_at
        then
            lead(fs2.id, 1)
            over (order by fs2.starts_at)
            else
                null
        end as nxt,
        case
            when
                lead(fs2.starts_at, 1)
                over (order by fs2.starts_at) < fs2.ends_at
            then
                fs2.id
            else
                null
        end as prev
    from film_show fs2
    join film f on f.id = fs2.film
    where fs2.show_date = current_date
) e
join film_show fs3 on fs3.id = prev
join film_show fs4 on fs4.id = nxt
join film f2 on fs3.film = f2.id
join film f3 on fs4.film = f3.id
where prev is not null

--перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
--Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

--С учетом ошибок в поле перерыва есть NULL значения
select f.title, fs2.starts_at, f.duration,
    lead(fs2.starts_at, 1)
    over (order by fs2.starts_at) as next_show,
    case
        when lead(fs2.starts_at, 1)
            over (order by fs2.starts_at) > fs2.ends_at
        then lead(fs2.starts_at, 1)
            over (order by fs2.starts_at)::time - fs2.ends_at::interval
	    else
	        null
    end as break
from film_show fs2
join film f on f.id = fs2.film
where fs2.show_date = current_date
order by fs2.starts_at

--список фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму
--(отсортировать по убыванию прибыли).

--Не получилось сортировать по убыванию, чтоб при этом "Итого" не переносилось в первую строку

--Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;
select f.title as "Наименование",
       count(t."number") as "Количество посетителей",
       r.avg_per_show as "Среднее посещаемость",
       sum(p.price) as "Прибыль"
from tickets t
         join film_show fs2 on t."show" = fs2.id
         join prices p on p.id = fs2.price
         join film f on f.id = fs2.film
         join (
    select g.id, g.avg_per_show
    from (
             select id,
                    avg(avg_per_show) over(partition by id rows between unbounded preceding and unbounded following) as avg_per_show
             from (
                      select f.id as id, count(t."number") as avg_per_show
                      from tickets t
                               join film_show fs2 on t."show" = fs2.id
                               join film f on f.id = fs2.film
                      group by t."show", f.id
                      order by t."show"
                  ) a
         ) g
    group by avg_per_show, id) r on r.id = f.id
group by f.title, r.avg_per_show
union
select 'Итого', null, null, sum(p2.price)
from film_show fs3
         join prices p2 on fs3.price = p2.id
         join tickets t2 on t2."show"  = fs3.id
order by "Прибыль"

--число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
--с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).
select count(t."number") as "Количество посетителей",
       sum(p.price) as "Кассовые сборы"
from tickets t
         join film_show fs2 on t."show" = fs2.id
         join prices p on p.id = fs2.price
         join film f on fs2.film = f.id
group by p.seq_start, p.price
order by p.price