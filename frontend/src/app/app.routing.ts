import { Routes, RouterModule } from '@angular/router';

import { NewsComponent } from './components/news/news.component';

//aquí tenemos que completar todo lo que queremos que se vaya cargando en el router-outlet
//ojo, el template no debe llamar al servicio, hay que hacerlo a través del componente

const appRoutes = [
    { path: 'news', component: NewsComponent }
]

export const routing = RouterModule.forRoot(appRoutes);
