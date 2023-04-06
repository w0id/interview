angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:9099'

    $scope.loadStudents = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
                $scope.StudentList = response.data;
                $scope.count = response.data.length;
            });
    };

    $scope.deleteStudent = function (studentId) {
        $http.get(contextPath + '/students/delete/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.changeAge = function (studentId, delta) {
        $http({
            url: contextPath + '/students/change_age',
            method: 'POST',
            params: {
                studentId: studentId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadStudents();
        });
    }

    $scope.addStudent = function (form) {
        $http({
            url: contextPath + '/students',
            method: 'POST',
            params: {
                name: $scope.data.Name,
                age: $scope.data.Age
            }
        }).then(function (response) {
            $scope.loadStudents();
            $scope.data = {};
        });
    }

    $scope.loadStudents();
})