angular.module('superhelt.controller')
    .controller('SuperheroListController', SuperheroListController);

SuperheroListController.$inject = ['Superhero'];

function SuperheroListController(Superhero) {
    this.message = "I am the superherolist controllah!";
    var self = this;
    this.superheroes = Superhero.queryAll();

    console.log("such controller");
    console.log(this.superheroes);

    this.goToDetailsView = function($event, superheroId){
        $event.stopPropagation();
        console.log(superheroId);
    }

    this.editHero = function($event, superheroId){
        $event.stopPropagation();
        console.log("edit hero");
    };

    this.deleteHero = function($event, superhero){
        $event.stopPropagation();
        console.log(superhero);
        superhero.$delete();
        console.log("delte hero");
    }
}

