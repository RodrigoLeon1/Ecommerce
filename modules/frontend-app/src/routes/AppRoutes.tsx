import { lazy } from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import RoutesWrapper from './RoutesWrapper';

const Home = lazy(() => import('../pages/Home/Home'));
const Login = lazy(() => import('../pages/Auth/Login'));
const Register = lazy(() => import('../pages/Auth/Register'));

const AppRoutes = () => (
  <BrowserRouter>
    <RoutesWrapper>
      <Route index element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
    </RoutesWrapper>
  </BrowserRouter>
);

export default AppRoutes;
