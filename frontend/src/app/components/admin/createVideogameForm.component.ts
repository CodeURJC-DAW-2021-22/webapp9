import { Component, Input, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { News } from "src/app/models/news.model";
import { Videogame } from "src/app/models/videogame.model";
import { VideogameService } from "src/app/services/videogame.service";

@Component({
    selector: 'createVideogameForm',
    templateUrl: './createVideogameForm.component.html'
})

export class CreateVideogameForm {

    @Input() videogame!: Videogame;
    news!: News[];

    title!: string;
    price!: number;
    company!: string;
    continent!: string;
    genre!: string;
    description!: string;
    shortDescription!: string;
    history!: string;
    cpuR!: string;
    cpuM!: string;
    ramR!: string;
    ramM!: string;
    ssooR!: string;
    ssooM!: string;
    gpuR!: string;
    gpuM!: string;
    storageR!: string;
    storageM!: string;

    @ViewChild("file")
    file!: any;

    @ViewChild("file2")
    file2!: any;

    constructor(public router: Router, public videogameService: VideogameService, activatedRoute: ActivatedRoute) { }

    uploadImage(videogame: Videogame): void {

        const image = this.file.nativeElement.files[0];
        if (image) {
            let formData = new FormData();
            formData.append("imageFile", image);
            this.videogameService.uploadVideogameCompanyImage(videogame, formData).subscribe(
                (_: any) => {} ,
                error => alert('Error uploading book image: ' + error)
            );
        }
    }

    uploadImage2(videogame: Videogame): void {

        const image = this.file2.nativeElement.files[0];
        if (image) {
            let formData = new FormData();
            formData.append("imageFile", image);
            this.videogameService.uploadVideogameImage(videogame, formData).subscribe(
                (_: any) => this.afterUploadImage(videogame),
                error => alert('Error uploading book image: ' + error)
            );
        } else {
            this.afterUploadImage(videogame);
        }
    }

    private afterUploadImage(videogame: Videogame) {
        this.router.navigate(['/videogamecatalog']);
    }

    save() {
        
        this.videogame = {
            title: this.title, price: this.price, company: this.company,
            continent: this.continent, genre: this.genre, description: this.description,
            shortDescription: this.shortDescription, history: this.history, cpuR: this.cpuR,
            cpuM: this.cpuM, ramR: this.ramR, ramM: this.ramM, ssooR: this.ssooR,
            ssooM: this.ssooM, gpuR: this.gpuR, gpuM: this.gpuM, storageR: this.storageR,
            storageM: this.storageM, imageVg: false, imageCompany: false, rating: 0
        }

        this.videogameService.createVideogame(this.videogame).subscribe(
            (videogame) => {this.uploadImage(videogame as Videogame);
                            this.uploadImage2(videogame as Videogame)},
            (error: string) => alert('Error al guardar los datos: ' + error)
        );

        this.router.navigate(['/videogamecatalog']);
    }

    cancel() {
        window.history.back();
    }

}