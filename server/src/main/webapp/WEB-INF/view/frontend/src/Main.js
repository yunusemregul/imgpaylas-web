import React from "react";
import { withRouter } from "react-router";
import content from "./assets/content.png";
import Header from "./Header";

function Main() {
  return (
    <div>
      <Header />
      <div style={{ overflow: "hidden" }}>
        <img src={content} alt="content-background" />
      </div>
    </div>
  );
}

export default withRouter(Main);
