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
import { EditNewComponent } from './components/news/editNew.component';
import { EditNewFormComponent } from './components/news/editNewForm.component';



import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CarouselComponent } from './components/carousel/carousel.component';
import { AboutComponent } from './components/about/about.component';




@NgModule({
  declarations: [EditNewFormComponent,EditNewComponent,AboutComponent,CarouselComponent,AppComponent,VideogamePurchaseComponent,VideogameEditFormComponent, LoginComponent, HeadComponent, NewsComponent, NavBarComponent, FooterComponent, NewsTemplateComponent,VideogameCatalogComponent, ShowNewsComponent, HomeComponent, UserProfile,VideogameCardComponent],
  imports: [BrowserModule,NgbModule, FormsModule, HttpClientModule, routing, FormsModule,RouterModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
