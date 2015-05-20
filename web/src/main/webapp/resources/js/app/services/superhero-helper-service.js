angular.module('superhelt.service')
    .factory('SuperheroHelperService', SuperheroHelperService);

SuperheroHelperService.$inject = ['$http'];

function SuperheroHelperService($http) {
    return {
        getGroupAffiliations: function () {
            var promise = $http.get("superhero/group/getAll")
                .success(function(data, status, headers, config){
                    return data;
                });

            return promise;
        }
    };
}