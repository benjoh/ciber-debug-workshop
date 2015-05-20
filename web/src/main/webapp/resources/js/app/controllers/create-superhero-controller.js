angular.module('superhelt.controller')
    .controller('CreateSuperheroController', CreateSuperheroController);

CreateSuperheroController.$inject = ['Superhero', 'SuperheroHelperService'];

function CreateSuperheroController(Superhero, SuperheroHelperService) {
    var self = this;
    this.hero = new Superhero();
    SuperheroHelperService.getGroupAffiliations().then(function(response){
        self.groups = response.data;
        console.log(self.groups);
    });



    this.save = function(form, $event) {
        $event.preventDefault();

        this.hero.$save(function(data){
            console.log(data);
        })
        /*form.$submitted = true;
        PubSubService.publish('submitForm');

        if (!form.$invalid) {
            self.station.$save(function (data) {
                if (self.addMore === true) {
                    PubSubService.publish('alert', 'success', {message: "Suksess! Målestasjonen " + data.name + " ble lagret. Målestasjonsnummeret er " + data.id});
                    self.clearForm(form, $event);
                } else {
                    if( $location.path().indexOf('oversikt') > -1){
                        $state.reload();
                    }else {
                        $location.path("/oversikt/" + data.id);
                    }
                }
            }, function (error, status, headers, config) {
                error.data.action = 'Opprett stasjon';
                error.data.data = JSON.stringify(self.data);
                PubSubService.publish('alert', 'danger', error.data, {error: true});
            });
        } else {
            PubSubService.publish('alert', 'danger', {message: "Et eller flere felter er ikke fylt ut riktig. Rett feilene og prøv igjen."});
        }*/
    };

    this.clearForm = function(form, $event){
        $event.preventDefault();
        form.$setPristine();
        this.hero = new Superhero();
        /*form.$setUntouched();*/
/*
        form.$submitted = false;
        self.station = StationData.getFreshStation();

        PubSubService.publish("resetLocalization");
        PubSubService.publish("removeMarker", 'station');
        StationData.setStationStatus(self.stationStatuses[0]);
        StationData.setStationType(self.stationTypes[0]);*/
    };

}

