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

    this.deleteHeroesInGroup = function($event){
        $event.stopPropagation();
        this.superheroes = Superhero.deleteAllInGroup({group:this.deleteFromGroup});
    }

    this.addXmen = function($event){
        $event.stopPropagation();
        var xmen = [];

        xmen[0] = this.createHero("Cyclops", "Scott Summers", "http://orig14.deviantart.net/37ba/f/2013/141/4/4/90_s_cyclops_by_claret821021-d663he3.png");
        xmen[1] = this.createHero("Storm", "Ororo Munroe", "http://i159.photobucket.com/albums/t128/coolcat618/mugen_comics_characters_storm_x_men.gif");
        xmen[2] = this.createHero("Nightcrawler", "Kurt Wagner", "http://www.classicmarvelforever.com/images/nightcrawler.gif");
        xmen[3] = this.createHero("The White Queen", "Emma Frost", "http://vignette3.wikia.nocookie.net/avengersalliance/images/5/5e/Emma_Frost-Modern-iOS.png/revision/latest?cb=20131213003622" );

        for(var i = 0; i<xmen.length; i++){
            xmen[i].$save(function() {
                self.superheroes.push(xmen[i]);
            });
        }
    };

    this.createHero = function(heroName, realName, url){
        var hero = new Superhero();
        hero.heroName = heroName;
        hero.realName = realName;
        hero.imageUrl = url;
        hero.groupAffiliation = "X_MEN";
        return hero;
    }
}

