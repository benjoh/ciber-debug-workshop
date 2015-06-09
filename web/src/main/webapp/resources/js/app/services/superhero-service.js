angular.module('superhelt.service')
    .factory('Superhero', Superhero);

Superhero.$inject = ['$resource'];

function Superhero($resource) {
    return $resource('crud/superhero/', {id:'@id', group:'@group'}, {
        queryAll: {
            url: 'crud/superhero/getAll',
            method: 'GET',
            cache: false,
            isArray: true
        },
        update: {
            method: 'POST'
        },
        deleteAllInGroup: {
            url:'crud/superhero/allInGroup',
            method: 'GET',
            params: {
              group:'@group'
            },
            cache: false,
            isArray: true
        }
    });
}