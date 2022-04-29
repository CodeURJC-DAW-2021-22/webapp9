import { Routes, RouterModule } from '@angular/router';
import { VideogameDetailComponent } from './components/videogame/videogame-detail.component';
import { VideogameCatalogComponent } from './components/videogame/videogame-catalog.component';

import { HomeComponent } from './components/home/home.component';

//aquí tenemos que completar todo lo que queremos que se vaya cargando en el router-outlet
//ojo, el template no debe llamar al servicio, hay que hacerlo a través del componente

const appRoutes = [
    { path: 'home', component: HomeComponent },
    { path: 'videogamecatalog', component: VideogameCatalogComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }

]

export const routing = RouterModule.forRoot(appRoutes);
