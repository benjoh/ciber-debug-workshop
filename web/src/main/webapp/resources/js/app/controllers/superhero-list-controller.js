angular.module('superhelt.controller')
    .controller('SuperheroListController', SuperheroListController);

SuperheroListController.$inject = ['Superhero'];

function SuperheroListController(Superhero) {
    this.message = "I am the superherolist controllah!";
    var self = this;
    this.superheroes = Superhero.queryAll();

    console.log("such controller");
    console.log(this.superheroes);
}

