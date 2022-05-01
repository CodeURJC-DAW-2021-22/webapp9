import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";

import { News } from "src/app/models/news.model";
import { NewsService } from "src/app/services/news.service";


@Component({
    selector: 'createNew',
    templateUrl: './createNew.component.html'
})

export class CreateNewComponent {

    news!: News;

    constructor(public newsService: NewsService, activatedRoute: ActivatedRoute, private router: Router) {
        const id = activatedRoute.snapshot.params['id'];
        this.newsService.getNew(id).subscribe(
            (news) => this.news = news as News,
            (error: any) => console.error(error)
        )
    }

}