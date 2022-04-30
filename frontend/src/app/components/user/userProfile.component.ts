import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


import { Usero } from './../../models/usero.model';
import { UseroService } from '../../services/usero.service';
import { LoginService } from '../../services/login.service';
import { Videogame } from 'src/app/models/videogame.model';

@Component({
  selector: 'userProfile',
  templateUrl: './userProfile.component.html'
})
export class UserProfile {

  user!: Usero;
  videogame! : Videogame[];
  @ViewChild("file")
  file: any;
  removeImage? :boolean;

  constructor(private router: Router, activatedRoute: ActivatedRoute,public useroService: UseroService, public loginservice : LoginService) {
    const id = activatedRoute.snapshot.params['id'];
    if (id) {
      useroService.getUser(id).subscribe(
        (user: Usero) => {this.user = user},
        (error: any) => console.error(error)
      );
  }
  useroService.getVideogames(this.user).subscribe(
    (videogame: Videogame[]) => videogame = videogame,
    (error: any) => console.error(error)
  );
}

ngOnInit(){
  alert(this.user);
}

  save(){
    this.useroService.updateUser(this.user).subscribe(
      (user: any) => this.uploadImage(user),
      (error: string) => alert('Error al guardar los datos: ' + error)
    );
  }
  cancel(){
    window.history.back();
  }

  uploadImage(user: Usero): void {
    const image = this.file.nativeElement.files[0];
    if (image) {
      let formData = new FormData();
      formData.append("imageFile", image);
      this.useroService.setUserImage(user, formData).subscribe(
        (_: any) => this.afterUploadImage(),
        ( error: string) => alert('Error al actualizar o subir la imagen: ' + error)
      );
    } else {
      this.afterUploadImage();
    }
  }

  private afterUploadImage(){
    this.router.navigate(['/userProfile/']);
  }

  userImage() {
    return this.user.image? '/api/users/' + this.user.id + '/image' : '/assets/images/defaultProfilePhoto';
  }

  videogameImage(vg: Videogame) {
    return vg.imageVg? '/api/videogames/' + vg.id + '/image' : '/assets/images/defaultProfilePhoto';
  }

  logOut(){
    this.loginservice.logOut();
  }
}
