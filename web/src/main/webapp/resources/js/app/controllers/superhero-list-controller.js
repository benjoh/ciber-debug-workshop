angular.module('superhelt.controller')
    .controller('SuperheroListController', SuperheroListController);

SuperheroListController.$inject = ['Superhero', '$location', 'SuperheroHelperService'];

function SuperheroListController(Superhero, $location, SuperheroHelperService) {
    this.message = "I am the superherolist controllah!";
    var self = this;
    this.superheroes = Superhero.queryAll();

    SuperheroHelperService.getGroupAffiliations().then(function(response){
        self.groups = response.data;
    });

    this.goToDetailsView = function($event, superheroId){
        $event.stopPropagation();

        $location.path("/detaljer/" + superheroId);
    };

    this.deleteHero = function($event, superhero){
        $event.stopPropagation();
        superhero.$delete();
    }
}

