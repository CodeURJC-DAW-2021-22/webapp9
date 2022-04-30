import { Component } from "@angular/core";
import { News } from "src/app/models/news.model";

@Component ({
    selector: 'createNew',
    template: './createNew.component.html'
})

export class CreateNewComponent {
    news: News | undefined;

    title: string | undefined;
    date: string | undefined;
    readtime: string | undefined;
    bagde: string | undefined;
    content: string | undefined;
    header: string | undefined;
    image: boolean | undefined;

    
    constructor(title: string, date: string, readtime: string, bagde: string, content: string, header: string, image: boolean) {
        this.news = {title: title, date: '', readTime: readtime, badge: bagde, description: content, argument: header, image: image}
    }

}