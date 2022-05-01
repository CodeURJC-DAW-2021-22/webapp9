import { Component, Input, ViewChild } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Videogame } from 'src/app/models/videogame.model';
import { VideogameService } from 'src/app/services/videogame.service';

@Component({
  selector: 'videogame-edit-form',
  templateUrl: './videogame-edit-form.component.html'
})

export class VideogameEditFormComponent{

  videogame!: Videogame;
  ready:boolean = false;

  @ViewChild("file")
  file: any;

  @ViewChild("file1")
  file1: any;

  constructor(private router: Router, activatedroute:ActivatedRoute, public videogameService: VideogameService){
    const id = activatedroute.snapshot.params['id'];
    videogameService.getVideogame(id).subscribe(      
      data => {console.log(data);this.videogame= data as Videogame},
      error => console.error(error)
    )

  }


  ngOnInit(){
    this.ready = true;
  }
  
  cancel() {
    window.history.back();
  }

  save() {
    this.videogameService.updateVideogame(this.videogame).subscribe(
      videogame => this.uploadImage(videogame as Videogame),
      error => alert('Error creating new book: ' + error)
    );
  }

  uploadImage(videogame: Videogame): void {

    const image = this.file.nativeElement.files[0];
    if (image) {
      let formData = new FormData();
      formData.append("imageFile", image);
      this.videogameService.uploadVideogameImage(videogame, formData).subscribe(
        _ => this.afterUploadImage(videogame),
        error => alert('Error uploading book image: ' + error)
      );
    } else {
      this.afterUploadImage(videogame);
    }
  }
  
  private afterUploadImage(videogame: Videogame){
    this.router.navigate(['/videogame/', videogame.id]);
  }

}