angular.module('superhelt.controller')
    .controller('EditSuperheroController', EditSuperheroController);

EditSuperheroController.$inject = ['$stateParams', '$location', 'Superhero', 'SuperheroHelperService'];

function EditSuperheroController($stateParams, $location, Superhero, SuperheroHelperService) {
    var self = this;
    var id = $stateParams.id;
    this.hero = Superhero.get({id:id});

    SuperheroHelperService.getGroupAffiliations().then(function(response){
        self.groups = response.data;
    });

    SuperheroHelperService.getMovies().then(function(response){
        angular.forEach(response.data, function(movieItem){
           angular.forEach(self.hero.movieAppearances, function(movie){
               if(movieItem.title == movie.title) movieItem.ticked = true;
           });
        });
        self.movies = response.data;
    });

    this.save = function(form, $event) {
        $event.preventDefault();
        this.hero.$save();
        $location.path("/oversikt/")
    };

    this.cancelEdit = function(form, $event){
        $location.path("/oversikt/")
    };

}

