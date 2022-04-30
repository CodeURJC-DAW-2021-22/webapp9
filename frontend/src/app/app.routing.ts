import { Routes, RouterModule } from '@angular/router';
import { VideogameDetailComponent } from './components/videogame/videogame-detail.component';
import { VideogameCatalogComponent } from './components/videogame/videogame-catalog.component';

import { HomeComponent } from './components/home/home.component';
import { NewsComponent } from './components/news/news.component';
import { ShowNewsComponent } from './components/news/showNews.component';
import { UserProfile } from './components/user/userProfile.component';
import { AboutComponent } from './components/about/about.component';

//aquí tenemos que completar todo lo que queremos que se vaya cargando en el router-outlet
//ojo, el template no debe llamar al servicio, hay que hacerlo a través del componente

const appRoutes = [
    { path: 'home', component: HomeComponent },
    { path: 'news', component: NewsComponent },
    { path: 'showNews/:id', component: ShowNewsComponent},
    { path: 'userProfile', component: UserProfile},
    { path: 'videogamecatalog', component: VideogameCatalogComponent },
    { path: 'videogame/:id', component: VideogameDetailComponent },
    { path: 'about', component: AboutComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }

]

export const routing = RouterModule.forRoot(appRoutes);
