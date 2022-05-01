import { Component, Input } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { News } from "src/app/models/news.model";
import { Videogame } from "src/app/models/videogame.model";
import { NewsService } from "src/app/services/news.service";

@Component({
    selector: 'createNewForm',
    templateUrl: './createNewForm.component.html'
})

export class CreateNewFormComponent {
    @Input() news!: News;
    videogame!: Videogame[];

    title!: string;
    date!: string;
    read_time!: string;
    badge!: string;
    content!: string;
    header!: string;
    image!: boolean;

    constructor(public router: Router, public newsService: NewsService, activatedRoute: ActivatedRoute){}

    addNew(title: string, date: string, readtime: string, bagde: string, content: string, header: string, image: boolean) {
        this.news = { title: title, date: date, readTime: readtime, badge: bagde, description: content, argument: header, image: image }
    }

    updateNewImage() {

    }

}