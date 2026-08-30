import {
  Card,
  CardHeader,
  CardTitle,
  CardDescription,
  CardAction,
  CardContent,
  CardFooter,
} from "@/components/ui/card";
import { LineChartConfig } from "./LineChart";

export function RevenueCard() {
  return (
    <Card>
      <CardHeader>
        <CardTitle className="font-roboto text-3xl flex justify-between">
          <span>Total Sales</span>
          <span>$ 100</span>
        </CardTitle>
      </CardHeader>
      <CardContent>
        <LineChartConfig />
      </CardContent>
    </Card>
  );
}
