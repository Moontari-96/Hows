import { Banner } from './Banner/Banner';
import { Category } from './Category/Category';
import { Product } from './Product/Product';
import styles from './Main.module.css'
import { Route, Routes } from 'react-router-dom';
import { Best } from './Best/Best';

export const Main = () => {
  return (
    <div className={styles.container}>
        <Routes>
            <Route path='/' element={<Product />} />
            <Route path='product' element={<Product />} />
            <Route path='category' element={<Category/>}></Route>
            <Route path='best' element={<Best/>}></Route>
        </Routes>
    </div>
  );
}