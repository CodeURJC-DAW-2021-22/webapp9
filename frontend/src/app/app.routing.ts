import { Routes, RouterModule } from '@angular/router';
import { VideogameDetailComponent } from './components/videogame/videogame-detail.component';
import { VideogameCatalogComponent } from './components/videogame/videogame-catalog.component';

import { HomeComponent } from './components/home/home.component';
import { NewsComponent } from './components/news/news.component';
import { ShowNewsComponent } from './components/news/showNews.component';
import { UserProfile } from './components/user/userProfile.component';
<<<<<<< HEAD
import { EditNewComponent } from './components/Admin/editNew.component';
=======
import { AboutComponent } from './components/about/about.component';
import { LoginComponent } from './components/login/login.component';
import { SignUpComponent } from './components/login/signUp.component';
import { VideogameRecommendedComponent } from './components/videogame-recommended/videogame-recommended.component';
>>>>>>> 5326ceb9b76e8cf80fe1ecdf216c811dd535b8e5

//aquí tenemos que completar todo lo que queremos que se vaya cargando en el router-outlet
//ojo, el template no debe llamar al servicio, hay que hacerlo a través del componente

const appRoutes = [
    { path: 'home', component: HomeComponent },
    { path: 'news', component: NewsComponent },
    { path: 'showNews/:id', component: ShowNewsComponent},
    { path: 'userProfile', component: UserProfile},
    { path: 'videogamecatalog', component: VideogameCatalogComponent },
    { path: 'videogame/:id', component: VideogameDetailComponent },
<<<<<<< HEAD
    { path: 'new/edit/:id', component: EditNewComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }
=======
    { path: 'about', component: AboutComponent },
    { path: 'login', component: LoginComponent },
    { path: 'signUp', component: SignUpComponent },
    { path: 'videogameRecommended', component: VideogameRecommendedComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: '**', redirectTo: 'home' }
>>>>>>> 5326ceb9b76e8cf80fe1ecdf216c811dd535b8e5

]

export const routing = RouterModule.forRoot(appRoutes);
