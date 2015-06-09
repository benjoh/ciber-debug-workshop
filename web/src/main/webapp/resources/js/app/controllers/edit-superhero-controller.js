angular.module('superhelt.controller')
    .controller('EditSuperheroController', EditSuperheroController);

EditSuperheroController.$inject = ['$stateParams', '$location', 'Superhero', 'SuperheroHelperService'];

function EditSuperheroController($stateParams, $location, Superhero, SuperheroHelperService) {
    var id = $stateParams.id;
    this.hero = Superhero.get({id:id});
    this.groups;;
    this.movies;;

    SuperheroHelperService.getGroupAffiliations().then(function(response){
        this.groups = response.data;
    });

    SuperheroHelperService.getMovies().then(function(response){
        if(this.hero){
            angular.forEach(response.data, function(movieItem){
               angular.forEach(this.hero.movieAppearances, function(movie){
                   if(movieItem.title == movie.title) movieItem.ticked = true;
               });
            });
        }
        this.movies = response.data;
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

