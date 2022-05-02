import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";

import { Videogame } from "src/app/models/videogame.model";
import { VideogameService } from "src/app/services/videogame.service";

@Component({
    selector: 'createVideogame',
    templateUrl: './createVideogame.component.html'
})

export class CreateVideogame {

    videogame!: Videogame;

    constructor(public newsService: VideogameService, activatedRoute: ActivatedRoute, private router: Router) {
        const id = activatedRoute.snapshot.params['id'];
        this.newsService.getVideogame(id).subscribe(
            (videogame) => this.videogame = videogame as Videogame,
        )
    }
}