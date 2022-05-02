import { Routes, RouterModule } from '@angular/router';
import { VideogameDetailComponent } from './components/videogame/videogame-detail.component';
import { VideogameCatalogComponent } from './components/videogame/videogame-catalog.component';
import { VideogameEditFormComponent } from './components/videogame/videogame-edit-form.component';
import { VideogamePurchaseComponent } from './components/videogame/videogame-purchase.component';

import { HomeComponent } from './components/home/home.component';
import { CreateNewComponent } from './components/admin/createNew.component';
import { NewsComponent } from './components/news/news.component';
import { ShowNewsComponent } from './components/news/showNews.component';
import { UserProfile } from './com./components/admin/editNew.component
import { EditNewComponent } from './components/Admin/editNew.component';
import { AboutComponent } from './components/about/about.component';
import { LoginComponent } from './components/login/login.component';
import { SignUpComponent } from './components/login/signUp.component';
import { VideogameRecommendedComponent } from './components/videogame-recommended/videogame-recommended.component';
import { AdminComponent } from './components/admin/admin.component';
import { CreateVideogame } from './components/admin/createVideogame.component';

//aquí tenemos que completar todo lo que queremos que se vaya cargando en el router-outlet
//ojo, el template no debe llamar al servicio, hay que hacerlo a través del componente

const appRoutes = [
    { path: 'home', component: HomeComponent },
    { path: 'news', component: NewsComponent },
    { path: 'showNews/:id', component: ShowNewsComponent },
    { path: 'userProfile', component: UserProfile },
    { path: 'videogamecatalog', component: VideogameCatalogComponent },
    { path: 'videogame/:id', component: VideogameDetailComponent },
    { path: 'videogame/edit/:id', component: VideogameEditFormComponent },
    { path: 'videogame/:id/purchase/:id2', component: VideogamePurchaseComponent },
    { path: 'new/edit/:id', component: EditNewComponent },
    { path: 'about', component: AboutComponent },
    { path: 'login', component: LoginComponent },
    { path: 'signUp', component: SignUpComponent },
    { path: 'videogameRecommended', component: VideogameRecommendedComponent },
    { path: 'admin', component: AdminComponent },
    { path: 'createNew', component: CreateNewComponent },
    { path: 'createVideogame', component: CreateVideogame },
    { path: '**', redirectTo: 'home' }

]

export const routing = RouterModule.forRoot(appRoutes);
