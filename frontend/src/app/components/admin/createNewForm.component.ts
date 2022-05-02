import { Component, Input, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { News } from "src/app/models/news.model";
import { Videogame } from "src/app/models/videogame.model";
import { NewsService } from "src/app/services/news.service";
import { VideogameService } from "src/app/services/videogame.service";

@Component({
    selector: 'createNewForm',
    templateUrl: './createNewForm.component.html'
})

export class CreateNewFormComponent {
    @Input() news!: News;
    videogame!: Videogame[];

    title!: string;
    date!: string;
    readTime!: string;
    badge!: string;
    description!: string;
    argument!: string;

    @ViewChild("file")
    file!: any;

    constructor(public router: Router, public newsService: NewsService, activatedRoute: ActivatedRoute, private vs: VideogameService) { }

    ngOnInit() {
        this.vs.getVideogames().subscribe(
            videogame => this.videogame = videogame,
            error => console.log(error)
        );
    }

    uploadImage(news: News): void {

        const image = this.file.nativeElement.files[0];
        if (image) {
            let formData = new FormData();
            formData.append("imageFile", image);
            this.newsService.uploadNewImage(news, formData).subscribe(
                (_: any) => this.afterUploadImage(news),
                error => alert('Error uploading book image: ' + error)
            );
        } else {
            this.afterUploadImage(news);
        }
    }

    private afterUploadImage(news: News) {
        this.router.navigate(['/admin']);
    }

    save() {

        this.news = {
            title: this.title, date: this.date, readTime: this.readTime,
            badge: this.badge, description: this.description, argument: this.argument, image: false
        }

        this.newsService.createNew(this.news).subscribe(
            (news) => this.uploadImage(news as News),
            (error: string) => alert('Error al guardar los datos: ' + error)
        );
        this.router.navigate(['/news']);
    }

    cancel() {
        window.history.back();
    }

}