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
<<<<<<< HEAD
import { AdminComponent } from './components/admin/admin.component';
import { CreateNewComponent } from './components/news/createNew.component';
=======
import { VideogameCardComponent } from './components/videogame/videogame-card.component';
import { VideogameCatalogComponent } from './components/videogame/videogame-catalog.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CarouselComponent } from './components/carousel/carousel.component';
import { AboutComponent } from './components/about/about.component';
>>>>>>> bad7e16839e1088a5b5284b7de9aa0c4cae96619




@NgModule({
<<<<<<< HEAD
  declarations: [AppComponent, LoginComponent, HeadComponent, NewsComponent, NavBarComponent, FooterComponent, NewsTemplateComponent, ShowNewsComponent, HomeComponent, UserProfile, AdminComponent, CreateNewComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, routing, FormsModule],
=======
  declarations: [UserProfile,AppComponent, LoginComponent, HeadComponent, NewsComponent, NavBarComponent, FooterComponent, NewsTemplateComponent,VideogameCatalogComponent, ShowNewsComponent, HomeComponent, UserProfile,VideogameCardComponent, CarouselComponent, AboutComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, routing, FormsModule,RouterModule, NgbModule],
>>>>>>> bad7e16839e1088a5b5284b7de9aa0c4cae96619
  bootstrap: [AppComponent]
})
export class AppModule { }
