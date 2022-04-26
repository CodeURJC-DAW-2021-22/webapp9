import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule, Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/header/header.component';
import { NewsComponent } from './components/news/news.component';
import { NavBarComponent } from './components/navBar/navBar.component';
import { FooterComponent } from './components/footer/footer.component';
import { NewsTemplateComponent } from './components/news/newsTemplate.component';
import { ShowNewsComponent } from './components/news/showNews.component';


@NgModule({
  declarations: [AppComponent, LoginComponent, HeaderComponent, NewsComponent, NavBarComponent, FooterComponent, NewsTemplateComponent, ShowNewsComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, routing],
  bootstrap: [AppComponent]
})
export class AppModule { }
