import { LastValueFromConfig } from "rxjs/internal/lastValueFrom";

export interface VideogamePage {

    content: Videogame[];
    empty: boolean;
    first: boolean;
    last: boolean;
    number: number;
    numberOfElements: number;
    size: number;
    pageable: any[];
    sort: boolean [];
}

export interface Videogame {
    id?: number;
    imageVg: boolean;
    imageCompany: boolean;
	title: string;
    price:number;
    rating:number;
    genre:string;
    company:string;
    continent:string;
    description:string;
    shortDescription:string;
    history:string;

    cpuR:string;
    ramR:string;
    ssooR:string;
    gpuR:string;
    storageR:string;

    cpuM:string;
    ramM:string;
    ssooM:string;
    gpuM:string;
    storageM:string;
}
