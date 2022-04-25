import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Usero } from 'src/app/models/usero.model';
import { UseroService } from '../../services/usero.service'; 

@Component({
  selector: 'userProfile',
  templateUrl: './usero.component.html'
})
export class UserProfile {

  user? : Usero;
  // FALTA AÑADIR VIDEOJUEGO Y TAMBIÉN UN MÉTODO DE IMAGEN DE VIDEOJUEGO...E IGUAL ALGO MÁS PARA MOSTRARLO BIEN
  @ViewChild("file")
  file: any;
  removeImage? :boolean;

  constructor(private router: Router, activatedRoute: ActivatedRoute,public useroService: UseroService) { 
    const id = activatedRoute.snapshot.params['id'];
    if (id) {
      useroService.getUser(id).subscribe(
        (user: Usero) => this.user = user,
        (error: any) => console.error(error)
      );
    }
  }


  save(){
    this.useroService.updateUser(this.user).subscribe(
      (user: Usero) => this.uploadImage(user),
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
        (_: any) => this.afterUploadImage(user),
        ( error: string) => alert('Error al actualizar o subir la imagen: ' + error)
      );
    } else {
      this.afterUploadImage(user);
    }
  }

  private afterUploadImage(user: Usero){
    this.router.navigate(['/usero/', user.id]); // NO ESTOY SEGURA DE ESA URL..SEGURAMENTE ESTÉ MAL. REVISARLA
  }

  userImage() {
    return this.user?.image? '/api/user/' + this.user?.id + '/image' : '/assets/images/defaultProfilePhoto'; 
  }

}