export interface NewsPage {

  content: News[];
  empty: boolean;
  first: boolean;
  last: boolean;
  number: number;
  numberOfElements: number;
  size: number;
  pageable: any[];
  sort: boolean [];
}


export interface News {
    id?: number;

    date:string;

    badge:string;

    readTime:string;

    description:string;

    argument:string;

    image:boolean;

    title:string;


}
