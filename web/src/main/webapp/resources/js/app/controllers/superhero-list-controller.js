angular.module('superhelt.controller')
    .controller('SuperheroListController', SuperheroListController);

SuperheroListController.$inject = ['Superhero', '$location', '$state', 'SuperheroHelperService'];

function SuperheroListController(Superhero, $location, $state, SuperheroHelperService) {
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
        superhero.$delete(function(){
            $state.reload();
        });
    }

    this.deleteRandomHero = function($event){
        $event.stopPropagation();
        var deletedHero = Superhero.deleteRandom();

        deletedHero.$promise.then(function(data){
            self.deletedMessage = data.heroName + " ble slettet";
            self.superheroes = Superhero.queryAll();
        });
    }
}

