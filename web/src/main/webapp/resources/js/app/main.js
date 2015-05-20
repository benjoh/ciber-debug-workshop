angular.module('superhelt', ['superhelt.directive', 'superhelt.controller', 'ui.router']).config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/");

        $stateProvider
            .state('oversikt', {
                url: "/",
                templateUrl: 'resources/views/list.html',
                controller: 'SuperheroListController',
                controllerAs: 'ctrl'
            })
            .state('opprettNy', {
                url: "/opprettNy",
                templateUrl: 'resources/views/create-hero-page.html',
                controller: "CreateSuperheroController",
                controllerAs: 'ctrl'
            });
            /*.state('oversikt', {
                url: "/oversikt/:id",
                templateUrl: 'resources/views/pages/overview-page.html'/!*,
                 controller: "OverviewController",
                 controllerAs: 'overview'*!/
            })
            .state('opprettNy', {
                url: "/opprettNy",
                templateUrl: 'resources/views/pages/create-station-page.html'/!*,
                 controller: "StationDataController",
                 controllerAs: 'ctrl'*!/
            })
            .state('avansertSok', {
                url: "/avansertSok",
                templateUrl: 'resources/views/search/advanced-search.html',
                controller: "AdvancedSearchController",
                controllerAs: 'advancedSearch'
            })
            .state('rapport', {
                url: "/rapport",
                templateUrl: 'resources/views/report/report.html',
                controller: "ReportController",
                controllerAs: 'report'
            })
            .state('minSide', {
                url: "/minSide",
                templateUrl: 'resources/views/user/user-main-page.html',
                controller: "MyPageController",
                controllerAs: 'myPage'
            })
            .state('admin', {
                url: "/admin",
                templateUrl: 'resources/views/admin/admin.html',
                controller: 'AdminController',
                controllerAs: 'admin'
            });*/
    }
]);


angular.module('superhelt.controller', ['superhelt.service']);
angular.module('superhelt.service', ['ngResource']);
angular.module('superhelt.directive', []);

// Register modules and dependencies
/*angular.module('superhelt.controller', ['superhelt.service']);
angular.module('superhelt.service', ['ngResource']);
*/
/*angular.module('superhelt.directive')
    .directive('superheltHeader', HeaderDirective);

function HeaderDirective() {
    return {
        restrict: 'AE',
        replace: 'true',
        scope: {},
        templateUrl: 'resources/views/header/header.html',
        link: function(scope, element, attrs, controller) {
            console.log("no no no??");
        }
    };
}*/
