import {
  Card,
  CardHeader,
  CardTitle,
  CardDescription,
  CardAction,
  CardContent,
  CardFooter,
} from "@/components/ui/card";
import { LucideIcon } from "lucide-react";

interface InstructionsComponentProps {
  icon: LucideIcon;
  title: string;
  description: string;
  color?: string;
}

export function InstructionsComponent({
  icon: Icon,
  title,
  description,
}: InstructionsComponentProps) {
  return (
    <Card className="w-auto max-w-100">
      <div className="flex md:justify-normal justify-center items-center p-5 gap-5">
        <Icon className="w-10 h-10 shrink-0" />
        <div className="flex flex-col ">
          <span className="font-bold">{title}</span>
          <span>{description}</span>
        </div>
      </div>
      <CardFooter></CardFooter>
    </Card>
  );
}
