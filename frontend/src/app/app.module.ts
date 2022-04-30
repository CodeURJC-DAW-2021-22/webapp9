import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule, Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
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
import { AdminComponent } from './components/admin/admin.component';




@NgModule({
  declarations: [AppComponent, LoginComponent, HeadComponent, NewsComponent, NavBarComponent, FooterComponent, NewsTemplateComponent, ShowNewsComponent, HomeComponent, UserProfile, AdminComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule, routing, FormsModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
