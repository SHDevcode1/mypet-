import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

import reportWebVitals from './reportWebVitals';

import Stateless from './components/Stateless';
import Stateful from './components/Stateful';
import PresentacionalConstantes from './components/PresentacionalConstantes'
import Button1 from './components/Button1';
import Button from './components/Button';
import GetGreeting from './components/GetGreeting';

ReactDOM.render(
  <React.StrictMode>
    <Stateless />
    <Stateful />
    <PresentacionalConstantes />
    <Button1 text="Click"/>
    <Button text="Click 2"/>
    <GetGreeting />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
