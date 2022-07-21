import NotFound from '@/pages/NotFound/NotFound';
import { Route, Routes } from 'react-router-dom';

interface Props {
  children: JSX.Element | JSX.Element[];
}

const RoutesWrapper = ({ children }: Props) => (
  <Routes>
    {children}
    <Route path="*" element={<NotFound />} />
  </Routes>
);

export default RoutesWrapper;
