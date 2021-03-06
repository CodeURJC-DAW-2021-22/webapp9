import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


import { Usero } from './../../models/usero.model';
import { UseroService } from '../../services/usero.service';
import { LoginService } from '../../services/login.service';
import { Videogame } from '../../models/videogame.model';

@Component({
  selector: 'userProfile',
  templateUrl: './userProfile.component.html'
})
export class UserProfile {

  user!: Usero;
  videogame!: Videogame[];
  @ViewChild("file")
  file: any;
  removeImage?: boolean;

  constructor(private router: Router, activatedRoute: ActivatedRoute, public useroService: UseroService, public loginservice: LoginService) {
    const id = loginservice.currentUser()?.id;
    if (id) {
      useroService.getMe().subscribe(
        (user) => this.user = user as Usero,
        (error: any) => console.error(error)
      );
    }
  }

  ngOnInit() {
    if (this.loginservice.currentUser()) {
      this.useroService.getVideogames(this.loginservice.currentUser() as Usero).subscribe(
        videogame => this.videogame = videogame as Videogame[],
        error => console.error(error)
      );
    }
  }

  save() {
    this.useroService.updateUser(this.user).subscribe(
      (user: any) => this.uploadImage(user as Usero),
      (error: string) => alert('Error al guardar los datos: ' + error)
    );
    this.router.navigate(['/userProfile']);
  }
  cancel() {
    window.history.back();
  }

  uploadImage(user: Usero): void {
    const image = this.file.nativeElement.files[0];
    if (image) {
      let formData = new FormData();
      formData.append("imageFile", image);
      this.useroService.setUserImage(user, formData).subscribe(
        (_: any) => this.afterUploadImage(),
        (error: string) => alert('Error al actualizar o subir la imagen: ' + error)
      );
    } else {
      this.afterUploadImage();
    }
  }

  private afterUploadImage() {
    this.router.navigate(['/userProfile/']);
  }

  userImage() {
    return this.user.image ? '/api/users/' + this.user.id + '/image' : '/assets/images/defaultProfilePhoto';
  }

  videogameImage(vg: Videogame) {
    return vg.imageVg ? '/api/videogames/' + vg.id + '/image' : '/assets/images/defaultProfilePhoto';
  }

  logOut() {
    this.loginservice.logOut();
    this.router.navigate(['/home']);
  }
}
