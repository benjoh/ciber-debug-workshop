angular.module('superhelt', [/*'superhelt.controller', 'superhelt.service', 'superhelt.directive'*/]).config(/*['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/hjem");

        $stateProvider
            .state('hjem', {
                url: "/hjem",
                views: {
                    '' : {
                        templateUrl: 'resources/views/home/home.html'
                    },
                    'map@hjem' : {
                        templateUrl: 'resources/views/home-map.html',
                       controller: 'MapController',
                        controllerAs: 'mapCtrl'
                    }/*,
                    'sidebar@hjem' : {
                        templateUrl: 'resources/views/common/sidebar.html',
                        controller: 'SideBarController',
                        controllerAs: 'sideBar'
                    }*/
         /*       }
            })
            .state('oversikt', {
                url: "/oversikt/:id",
                templateUrl: 'resources/views/pages/overview-page.html'/*,
                controller: "OverviewController",
                controllerAs: 'overview'*/
          /*  })
            .state('opprettNy', {
                url: "/opprettNy",
                templateUrl: 'resources/views/pages/create-station-page.html'/*,
                controller: "StationDataController",
                controllerAs: 'ctrl'*/
     /*       })
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
            });
}]*/);

// Register modules and dependencies
/*angular.module('superhelt.controller', ['superhelt.service']);
angular.module('superhelt.service', ['ngResource']);
angular.module('superhelt.directive', []);*/