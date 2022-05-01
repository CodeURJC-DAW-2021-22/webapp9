import { Component, Input } from "@angular/core";
import { Router } from "@angular/router";
import { VideogameService } from "src/app/services/videogame.service";

@Component({
    selector: 'admin',
    templateUrl: './admin.component.html'
})

export class AdminComponent {

    vs!: VideogameService;

    constructor(public router: Router) {}

    /*getGraficaGenres() {
        return this.vs.graphicGenres();
    }

    getGraficaSales() {
        return this.vs.graphicSales
    }*/

    createNew() {
        this.router.navigate(['/createNew']);
    }
}