import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Header from './layout/Header.js';
import Aside from './layout/Aside.js';
import Section from './layout/Section.js';
import Footer from './layout/Footer.js';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <>
    <Header/>
    <Aside/>
    <Section/>
    <Footer/>
  </>
);

