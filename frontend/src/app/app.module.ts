import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule, Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {RouterModule} from '@angular/router';
import { routing } from './app.routing';


import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HeadComponent } from './components/head/head.component';
import { NewsComponent } from './components/news/news.component';
import { NavBarComponent } from './components/navBar/navBar.component';
import { FooterComponent } from './components/footer/footer.component';
import { NewsTemplateComponent } from './components/news/newsTemplate.component';
import { ShowNewsComponent } from './components/news/showNews.component';
import { HomeComponent } from './components/home/home.component';
import { UserProfile } from './components/user/userProfile.component';
import { VideogameCardComponent } from './components/videogame/videogame-card.component';
import { VideogameCatalogComponent } from './components/videogame/videogame-catalog.component';
import { VideogameEditFormComponent } from './components/videogame/videogame-edit-form.component';
import { VideogamePurchaseComponent } from './components/videogame/videogame-purchase.component';
import { VideogameDetailComponent } from './components/videogame/videogame-detail.component';
import { CommonModule } from '@angular/common';  


import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CarouselComponent } from './components/carousel/carousel.component';
import { EditNewComponent } from './components/admin/editNew.component';
import { EditNewFormComponent } from './components/admin/editNewForm.component'

import { AboutComponent } from './components/about/about.component';
import { VideogameRecommendedComponent } from './components/videogame-recommended/videogame-recommended.component';

import { AdminComponent } from './components/admin/admin.component';
import { CreateNewComponent } from './components/admin/createNew.component';
import { CreateNewFormComponent } from './components/admin/createNewForm.component'
import { CreateVideogame } from './components/admin/createVideogame.component';
import { CreateVideogameForm } from './components/admin/createVideogameForm.component';



@NgModule({
  declarations: [CreateVideogameForm,CreateVideogame,CreateNewFormComponent,CreateNewComponent,AdminComponent,VideogameRecommendedComponent,EditNewFormComponent,VideogameDetailComponent,EditNewComponent,AboutComponent,CarouselComponent,AppComponent,VideogamePurchaseComponent,VideogameEditFormComponent, LoginComponent, HeadComponent, NewsComponent, NavBarComponent, FooterComponent, NewsTemplateComponent,VideogameCatalogComponent, ShowNewsComponent, HomeComponent, UserProfile,VideogameCardComponent],
  imports: [BrowserModule,NgbModule, FormsModule, HttpClientModule, routing, FormsModule,RouterModule,CommonModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
