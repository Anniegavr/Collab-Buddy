<template>
  <section>
    <div>
      <canvas ref="canvas" width="600" height="500">
        <canvas ref="canvas2" width="300" height="250"></canvas>
      </canvas>
    </div>
  </section>
</template>

<script>
import axios from "axios";

export default {
  name: 'DonutChart',
  mounted() {
    this.plotData();
  },

  methods: {
    plotData() {
      const myColor = ["#1a639d","#f85900","#f5b23b","#3999d8","#35485d", "#35486d",
      "#ca0582", "#ca8229", "#1dca29", "#297fca", "#cf29ca", "#ca294f", "#a9ca29",
      "#29cac4", "#2c3e50", "#7fca29", "#bfbed7"];
      const myData = []
      const myLabel = []
      axios.get('http://localhost:8080/students/5/schedule')
          .then(response => {
            const data = response.data
            console.log(response.data)
            data.forEach(task => {
              myLabel.push(task.taskName);
              console.log(myLabel)
              myData.push(parseInt(task.hours));
              console.log(myData)
            });
            function getTotal() {
              let myTotal = 0;
              for (let j = 0; j < myData.length; j++) {
                myTotal += (typeof myData[j] == 'number') ? myData[j] : 0;
              }
              return myTotal;
            }
            const canvas = this.$refs.canvas;
            const canvas2 = this.$refs.canvas2;
            const x = (canvas.width)/2;
            const y = (canvas.height)/2;
            const r = 150;
            const ctx = canvas.getContext("2d");
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            let lastend = 0;
            const myTotal = getTotal();

            for (let i = 0; i < myData.length; i++) {
              ctx.fillStyle = myColor[i]
              ctx.beginPath();
              ctx.moveTo(x,y);
              ctx.arc(x,y,r,lastend,lastend+(Math.PI*2*(myData[i]/myTotal)),false);
              ctx.lineTo(x,y);
              ctx.fill();

              ctx.beginPath();
              let start = [];
              let end = [];
              let flip = 0;
              let textOffset = 0;
              const precentage = (myData[i]/myTotal)*100;
              start = this.getPoint(x,y,r-20,(lastend+(Math.PI*2*(myData[i]/myTotal))/2));
              end = this.getPoint(x,y,r+20,(lastend+(Math.PI*2*(myData[i]/myTotal))/2));
              if(start[0] <= x)
              {
                flip = -1;
                textOffset = -110;
              }
              else
              {
                flip = 1;
                textOffset = 10;
              }
              ctx.moveTo(start[0],start[1]);
              ctx.lineTo(end[0],end[1]);
              ctx.lineTo(end[0]+120*flip,end[1]);
              ctx.strokeStyle = "#bdc3c7";
              ctx.lineWidth = 2;
              ctx.stroke();

              ctx.font="2.5svh Helvetica"

              ctx.fillText(myLabel[i]+" "+precentage.toFixed(2)+"%",end[0]+textOffset,end[1]-4);

              lastend += Math.PI*2*(myData[i]/myTotal);
            }
            // draw small circle in the center
            const r2 = r / 2;
            ctx.fillStyle = "#FFFFFF";
            ctx.beginPath();
            ctx.arc(x, y, r2, 0, 2 * Math.PI);
            ctx.fill();
          }).catch(error => {
        console.error(error)
      })
    },
    getPoint(c1,c2,radius,angle) {
      return [c1+Math.cos(angle)*radius,c2+Math.sin(angle)*radius];
    }
  }
}
</script>