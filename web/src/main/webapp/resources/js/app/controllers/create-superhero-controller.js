angular.module('superhelt.controller')
    .controller('CreateSuperheroController', CreateSuperheroController);

CreateSuperheroController.$inject = ['Superhero', 'SuperheroHelperService', '$location'];

function CreateSuperheroController(Superhero, SuperheroHelperService, $location) {
    var self = this;
    this.hero = new Superhero();

    SuperheroHelperService.getGroupAffiliations().then(function(response){
        self.groups = response.data;
    });

    SuperheroHelperService.getMovies().then(function(response){
       self.movies = response.data;
    });

    this.save = function(form, $event) {
        $event.preventDefault();

        this.hero.$save(function(){
            $location.path("/oversikt/")
        });
    };

    this.clearForm = function(form, $event){
        $event.preventDefault();
        this.hero = new Superhero();
    };

}

