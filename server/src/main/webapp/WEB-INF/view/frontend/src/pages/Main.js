import React from "react";
import { withRouter } from "react-router";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";

function Main() {
  return (
    <div className="box">
      <Header />
      <DivBackground></DivBackground>
    </div>
  );
}

export default withRouter(Main);
