import { ThemeProvider } from '@mui/material/styles';
import AppContainer from './components/styled-components/AppContainer';
import AppRoutes from './routes/AppRoutes';
import AppTheme from './utilities/Theme/AppTheme';

const App = (): JSX.Element => {
  return (
    <ThemeProvider theme={AppTheme}>
      <AppContainer>
        <AppRoutes />
      </AppContainer>
    </ThemeProvider>
  );
};

export default App;
