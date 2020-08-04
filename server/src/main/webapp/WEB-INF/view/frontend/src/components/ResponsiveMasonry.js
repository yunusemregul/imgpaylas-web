import React, { useEffect, useState } from "react";
import Masonry from "react-masonry-css";

export default function ResponsiveMasonry(props) {
  const [width, setWidth] = useState(window.innerWidth);

  function updateSize() {
    setWidth(window.innerWidth);
  }

  useEffect(() => {
    window.addEventListener("resize", updateSize);

    return () => window.removeEventListener("resize", updateSize);
  });

  return (
    <Masonry
      breakpointCols={width < 400 ? 1 : Math.floor(width / 400)} // ekran genişliğine göre kaç tane fotoğraf column u olacağı
      className="my-masonry-grid"
      columnClassName="my-masonry-grid_column"
    >
      {props.children}
    </Masonry>
  );
}
