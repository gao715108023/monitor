/**
 *
 * @since 4/18/17
 * @author alfred
 */
var modules = [
    'ngRoute',
    'home'
];

var app = angular.module('monitor', modules);

app.controller('monitorCtrl', function ($scope, $http) {
    $http.get("/monitor/current")
        .success(function (response) {
            $scope.user = response;
        });
});

app.config(['$routeProvider', function ($routeProvider) {
    angular.forEach(modules, function (m) {
        $routeProvider.when('/' + m, {
            templateUrl: '/modules/' + m + '/index.html',
            controller: m + 'Ctrl'
        });
    });
}]);

app.service('handler', ['$scope', function ($scope) {
    return function (data) {
        if (data.code === 0) {
            $scope.alert = "Success";
            $scope.list();
        } else {
            $scope.alert = data.message;
        }
    }
}]);

app.filter('range', function () {
    return function (input, total) {
        total = parseInt(total);
        for (var i = 0; i < total; i++) {
            input.push(total - i);
        }
        return input;
    };
});

app.directive('checklistModel', ['$parse', '$compile', function ($parse, $compile) {
    // contains
    function contains(arr, item) {
        if (angular.isArray(arr)) {
            for (var i = 0; i < arr.length; i++) {
                if (angular.equals(arr[i], item)) {
                    return true;
                }
            }
        }
        return false;
    }

    // add
    function add(arr, item) {
        arr = angular.isArray(arr) ? arr : [];
        for (var i = 0; i < arr.length; i++) {
            if (angular.equals(arr[i], item)) {
                return arr;
            }
        }
        arr.push(item);
        return arr;
    }

    // remove
    function remove(arr, item) {
        if (angular.isArray(arr)) {
            for (var i = 0; i < arr.length; i++) {
                if (angular.equals(arr[i], item)) {
                    arr.splice(i, 1);
                    break;
                }
            }
        }
        return arr;
    }

    function postLinkFn(scope, elem, attrs) {
        // compile with `ng-model` pointing to `checked`
        $compile(elem)(scope);

        // getter / setter for original model
        var getter = $parse(attrs.checklistModel);
        var setter = getter.assign;

        // value added to list
        var value = $parse(attrs.checklistValue)(scope.$parent);

        // watch UI checked change
        scope.$watch('checked', function (newValue, oldValue) {
            if (newValue === oldValue) {
                return;
            }
            var current = getter(scope.$parent);
            if (newValue === true) {
                setter(scope.$parent, add(current, value));
            } else {
                setter(scope.$parent, remove(current, value));
            }
        });

        // watch original model change
        scope.$parent.$watch(attrs.checklistModel, function (newArr, oldArr) {
            scope.checked = contains(newArr, value);
        }, true);
    }

    return {
        restrict: 'A',
        priority: 1000,
        terminal: true,
        scope: true,
        compile: function (tElement, tAttrs) {
            if (tElement[0].tagName !== 'INPUT' || !tElement.attr('type', 'checkbox')) {
                throw 'checklist-model should be applied to `input[type="checkbox"]`.';
            }

            if (!tAttrs.checklistValue) {
                throw 'You should provide `checklist-value`.';
            }

            // exclude recursion
            tElement.removeAttr('checklist-model');

            // local scope var storing individual checkbox model
            tElement.attr('ng-model', 'checked');

            return postLinkFn;
        }
    };
}]);

Highcharts.setOptions({
                          global: {
                              useUTC: false
                          }
                      });