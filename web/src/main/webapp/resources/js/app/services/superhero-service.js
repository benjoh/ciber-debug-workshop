angular.module('superhelt.service')
    .factory('Superhero', Superhero);

Superhero.$inject = ['$resource'];

function Superhero($resource) {
    return $resource('crud/superhero/', {id:'@id'}, {
        queryAll: {
            url: 'crud/superhero/getAll',
            method: 'GET',
            cache: false,
            isArray: true
        },
        deleteRandom: {
            url:'crud/superhero/random',
            method: 'GET',
            cache: false
        }
    });
}