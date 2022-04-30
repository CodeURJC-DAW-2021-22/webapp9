import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';

import { HomeComponent } from './components/home/home.component';
import { CreateNewComponent } from './components/news/createNew.component';
import { NewsComponent } from './components/news/news.component';
import { ShowNewsComponent } from './components/news/showNews.component';
import { UserProfile } from './components/user/userProfile.component';

//aquí tenemos que completar todo lo que queremos que se vaya cargando en el router-outlet
//ojo, el template no debe llamar al servicio, hay que hacerlo a través del componente

const appRoutes = [
    { path: 'home', component: HomeComponent },
    { path: 'news', component: NewsComponent },
    { path: 'showNews', component: ShowNewsComponent},
    { path: 'userProfile', component: UserProfile},
    { path: 'admin', component: AdminComponent},
    { path: 'createNew', component: CreateNewComponent}
    { path: '', redirectTo: 'home', pathMatch: 'full'}
]

export const routing = RouterModule.forRoot(appRoutes);
