import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/header/header.component';
import { NewsComponent } from './components/news/news.component';
import { NavBarComponent } from './components/navBar/navBar.component'
import { VideogameCardComponent } from './components/videogame/videogame-card.component' 

@NgModule({
  declarations: [AppComponent, LoginComponent, HeaderComponent, NewsComponent, NavBarComponent,VideogameCardComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, routing,RouterModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
